.class public Lorg/drinkless/tdlib/TdApi$UserStatusRecently;
.super Lorg/drinkless/tdlib/TdApi$UserStatus;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UserStatusRecently"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0xfaa60b5


# instance fields
.field public byMyPrivacySettings:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 22556
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$UserStatus;-><init>()V

    .line 22557
    return-void
.end method

.method public constructor <init>(Z)V
    .locals 0
    .param p1, "z8"    # Z

    .line 22547
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$UserStatus;-><init>()V

    .line 22548
    iput-boolean p1, p0, Lorg/drinkless/tdlib/TdApi$UserStatusRecently;->byMyPrivacySettings:Z

    .line 22549
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 22553
    const v0, 0xfaa60b5

    return v0
.end method
