.class public Lorg/drinkless/tdlib/TdApi$SponsoredChat;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SponsoredChat"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x136ac1a1


# instance fields
.field public additionalInfo:Ljava/lang/String;

.field public chatId:J

.field public sponsorInfo:Ljava/lang/String;

.field public uniqueId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 45342
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 45343
    return-void
.end method

.method public constructor <init>(JJLjava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "str"    # Ljava/lang/String;
    .param p6, "str2"    # Ljava/lang/String;

    .line 45330
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 45331
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$SponsoredChat;->uniqueId:J

    .line 45332
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$SponsoredChat;->chatId:J

    .line 45333
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$SponsoredChat;->sponsorInfo:Ljava/lang/String;

    .line 45334
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$SponsoredChat;->additionalInfo:Ljava/lang/String;

    .line 45335
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 45339
    const v0, -0x136ac1a1

    return v0
.end method
