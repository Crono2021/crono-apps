.class public Lorg/drinkless/tdlib/TdApi$BotWriteAccessAllowReasonConnectedWebsite;
.super Lorg/drinkless/tdlib/TdApi$BotWriteAccessAllowReason;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "BotWriteAccessAllowReasonConnectedWebsite"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x782eafe3


# instance fields
.field public domainName:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 9168
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$BotWriteAccessAllowReason;-><init>()V

    .line 9169
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 9159
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$BotWriteAccessAllowReason;-><init>()V

    .line 9160
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$BotWriteAccessAllowReasonConnectedWebsite;->domainName:Ljava/lang/String;

    .line 9161
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 9165
    const v0, 0x782eafe3

    return v0
.end method
