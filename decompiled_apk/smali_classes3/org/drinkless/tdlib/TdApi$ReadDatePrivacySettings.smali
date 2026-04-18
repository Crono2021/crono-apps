.class public Lorg/drinkless/tdlib/TdApi$ReadDatePrivacySettings;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ReadDatePrivacySettings"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x62a2e628


# instance fields
.field public showReadDate:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 18366
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 18367
    return-void
.end method

.method public constructor <init>(Z)V
    .locals 0
    .param p1, "z8"    # Z

    .line 18357
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 18358
    iput-boolean p1, p0, Lorg/drinkless/tdlib/TdApi$ReadDatePrivacySettings;->showReadDate:Z

    .line 18359
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 18363
    const v0, 0x62a2e628

    return v0
.end method
