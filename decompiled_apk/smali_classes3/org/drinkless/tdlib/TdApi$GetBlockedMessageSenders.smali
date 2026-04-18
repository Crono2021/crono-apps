.class public Lorg/drinkless/tdlib/TdApi$GetBlockedMessageSenders;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetBlockedMessageSenders"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$MessageSenders;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x731ad0ea


# instance fields
.field public blockList:Lorg/drinkless/tdlib/TdApi$BlockList;

.field public limit:I

.field public offset:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 37158
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 37159
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$BlockList;II)V
    .locals 0
    .param p1, "blockList"    # Lorg/drinkless/tdlib/TdApi$BlockList;
    .param p2, "i9"    # I
    .param p3, "i10"    # I

    .line 37147
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 37148
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$GetBlockedMessageSenders;->blockList:Lorg/drinkless/tdlib/TdApi$BlockList;

    .line 37149
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$GetBlockedMessageSenders;->offset:I

    .line 37150
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$GetBlockedMessageSenders;->limit:I

    .line 37151
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 37155
    const v0, -0x731ad0ea

    return v0
.end method
