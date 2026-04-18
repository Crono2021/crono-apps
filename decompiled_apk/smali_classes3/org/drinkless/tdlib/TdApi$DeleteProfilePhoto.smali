.class public Lorg/drinkless/tdlib/TdApi$DeleteProfilePhoto;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "DeleteProfilePhoto"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x4eaa77c1


# instance fields
.field public profilePhotoId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 11346
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 11347
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 11337
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 11338
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$DeleteProfilePhoto;->profilePhotoId:J

    .line 11339
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 11343
    const v0, 0x4eaa77c1

    return v0
.end method
