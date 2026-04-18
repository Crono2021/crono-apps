.class public Lorg/drinkless/tdlib/TdApi$InputThumbnail;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputThumbnail"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x5e515024


# instance fields
.field public height:I

.field public thumbnail:Lorg/drinkless/tdlib/TdApi$InputFile;

.field public width:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 38084
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 38085
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$InputFile;II)V
    .locals 0
    .param p1, "inputFile"    # Lorg/drinkless/tdlib/TdApi$InputFile;
    .param p2, "i9"    # I
    .param p3, "i10"    # I

    .line 38073
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 38074
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InputThumbnail;->thumbnail:Lorg/drinkless/tdlib/TdApi$InputFile;

    .line 38075
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$InputThumbnail;->width:I

    .line 38076
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$InputThumbnail;->height:I

    .line 38077
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 38081
    const v0, 0x5e515024

    return v0
.end method
