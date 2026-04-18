.class public Lorg/drinkless/tdlib/TdApi$SearchChatRecentLocationMessages;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SearchChatRecentLocationMessages"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Messages;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x38a37ee6


# instance fields
.field public chatId:J

.field public limit:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 30528
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 30529
    return-void
.end method

.method public constructor <init>(JI)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "i9"    # I

    .line 30518
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 30519
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$SearchChatRecentLocationMessages;->chatId:J

    .line 30520
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$SearchChatRecentLocationMessages;->limit:I

    .line 30521
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 30525
    const v0, 0x38a37ee6

    return v0
.end method
