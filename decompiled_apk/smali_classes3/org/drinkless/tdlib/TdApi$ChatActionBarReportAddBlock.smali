.class public Lorg/drinkless/tdlib/TdApi$ChatActionBarReportAddBlock;
.super Lorg/drinkless/tdlib/TdApi$ChatActionBar;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatActionBarReportAddBlock"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x58067175


# instance fields
.field public accountInfo:Lorg/drinkless/tdlib/TdApi$AccountInfo;

.field public canUnarchive:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 23544
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatActionBar;-><init>()V

    .line 23545
    return-void
.end method

.method public constructor <init>(ZLorg/drinkless/tdlib/TdApi$AccountInfo;)V
    .locals 0
    .param p1, "z8"    # Z
    .param p2, "accountInfo"    # Lorg/drinkless/tdlib/TdApi$AccountInfo;

    .line 23534
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatActionBar;-><init>()V

    .line 23535
    iput-boolean p1, p0, Lorg/drinkless/tdlib/TdApi$ChatActionBarReportAddBlock;->canUnarchive:Z

    .line 23536
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$ChatActionBarReportAddBlock;->accountInfo:Lorg/drinkless/tdlib/TdApi$AccountInfo;

    .line 23537
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 23541
    const v0, -0x58067175

    return v0
.end method
