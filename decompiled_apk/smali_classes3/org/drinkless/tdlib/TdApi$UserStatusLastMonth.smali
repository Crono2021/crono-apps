.class public Lorg/drinkless/tdlib/TdApi$UserStatusLastMonth;
.super Lorg/drinkless/tdlib/TdApi$UserStatus;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UserStatusLastMonth"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x4734d604


# instance fields
.field public byMyPrivacySettings:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 22484
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$UserStatus;-><init>()V

    .line 22485
    return-void
.end method

.method public constructor <init>(Z)V
    .locals 0
    .param p1, "z8"    # Z

    .line 22475
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$UserStatus;-><init>()V

    .line 22476
    iput-boolean p1, p0, Lorg/drinkless/tdlib/TdApi$UserStatusLastMonth;->byMyPrivacySettings:Z

    .line 22477
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 22481
    const v0, -0x4734d604

    return v0
.end method
