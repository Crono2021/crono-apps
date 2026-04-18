.class public Lorg/drinkless/tdlib/TdApi$BotWriteAccessAllowReasonLaunchedWebApp;
.super Lorg/drinkless/tdlib/TdApi$BotWriteAccessAllowReason;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "BotWriteAccessAllowReasonLaunchedWebApp"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0xe5afb29


# instance fields
.field public webApp:Lorg/drinkless/tdlib/TdApi$WebApp;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 9186
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$BotWriteAccessAllowReason;-><init>()V

    .line 9187
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$WebApp;)V
    .locals 0
    .param p1, "webApp"    # Lorg/drinkless/tdlib/TdApi$WebApp;

    .line 9177
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$BotWriteAccessAllowReason;-><init>()V

    .line 9178
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$BotWriteAccessAllowReasonLaunchedWebApp;->webApp:Lorg/drinkless/tdlib/TdApi$WebApp;

    .line 9179
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 9183
    const v0, -0xe5afb29

    return v0
.end method
