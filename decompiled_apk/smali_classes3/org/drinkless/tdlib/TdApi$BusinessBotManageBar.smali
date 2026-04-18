.class public Lorg/drinkless/tdlib/TdApi$BusinessBotManageBar;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "BusinessBotManageBar"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x128f957e


# instance fields
.field public botUserId:J

.field public canBotReply:Z

.field public isBotPaused:Z

.field public manageUrl:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 42582
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 42583
    return-void
.end method

.method public constructor <init>(JLjava/lang/String;ZZ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "str"    # Ljava/lang/String;
    .param p4, "z8"    # Z
    .param p5, "z9"    # Z

    .line 42570
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 42571
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$BusinessBotManageBar;->botUserId:J

    .line 42572
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$BusinessBotManageBar;->manageUrl:Ljava/lang/String;

    .line 42573
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$BusinessBotManageBar;->isBotPaused:Z

    .line 42574
    iput-boolean p5, p0, Lorg/drinkless/tdlib/TdApi$BusinessBotManageBar;->canBotReply:Z

    .line 42575
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 42579
    const v0, -0x128f957e

    return v0
.end method
