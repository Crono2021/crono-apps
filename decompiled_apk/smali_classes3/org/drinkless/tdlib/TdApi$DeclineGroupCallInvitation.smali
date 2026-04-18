.class public Lorg/drinkless/tdlib/TdApi$DeclineGroupCallInvitation;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "DeclineGroupCallInvitation"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x6de7fa11


# instance fields
.field public chatId:J

.field public messageId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 24844
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 24845
    return-void
.end method

.method public constructor <init>(JJ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J

    .line 24834
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 24835
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$DeclineGroupCallInvitation;->chatId:J

    .line 24836
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$DeclineGroupCallInvitation;->messageId:J

    .line 24837
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 24841
    const v0, 0x6de7fa11

    return v0
.end method
