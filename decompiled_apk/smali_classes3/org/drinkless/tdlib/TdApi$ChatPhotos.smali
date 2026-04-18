.class public Lorg/drinkless/tdlib/TdApi$ChatPhotos;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatPhotos"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x5a0b70ac


# instance fields
.field public photos:[Lorg/drinkless/tdlib/TdApi$ChatPhoto;

.field public totalCount:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 24364
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 24365
    return-void
.end method

.method public constructor <init>(I[Lorg/drinkless/tdlib/TdApi$ChatPhoto;)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "chatPhotoArr"    # [Lorg/drinkless/tdlib/TdApi$ChatPhoto;

    .line 24354
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 24355
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$ChatPhotos;->totalCount:I

    .line 24356
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$ChatPhotos;->photos:[Lorg/drinkless/tdlib/TdApi$ChatPhoto;

    .line 24357
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 24361
    const v0, -0x5a0b70ac

    return v0
.end method
