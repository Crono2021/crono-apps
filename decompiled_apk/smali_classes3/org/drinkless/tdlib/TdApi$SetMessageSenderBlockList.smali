.class public Lorg/drinkless/tdlib/TdApi$SetMessageSenderBlockList;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetMessageSenderBlockList"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x7674a36f


# instance fields
.field public blockList:Lorg/drinkless/tdlib/TdApi$BlockList;

.field public senderId:Lorg/drinkless/tdlib/TdApi$MessageSender;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 31608
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31609
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$MessageSender;Lorg/drinkless/tdlib/TdApi$BlockList;)V
    .locals 0
    .param p1, "messageSender"    # Lorg/drinkless/tdlib/TdApi$MessageSender;
    .param p2, "blockList"    # Lorg/drinkless/tdlib/TdApi$BlockList;

    .line 31598
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31599
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SetMessageSenderBlockList;->senderId:Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 31600
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$SetMessageSenderBlockList;->blockList:Lorg/drinkless/tdlib/TdApi$BlockList;

    .line 31601
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 31605
    const v0, -0x7674a36f

    return v0
.end method
