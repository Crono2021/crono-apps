.class public Lorg/drinkless/tdlib/TdApi$GetBotMediaPreviews;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetBotMediaPreviews"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$BotMediaPreviews;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x22665458


# instance fields
.field public botUserId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 12120
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 12121
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 12111
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 12112
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetBotMediaPreviews;->botUserId:J

    .line 12113
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 12117
    const v0, 0x22665458

    return v0
.end method
