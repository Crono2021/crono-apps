.class public Lorg/drinkless/tdlib/TdApi$InputPaidMedia;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputPaidMedia"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x1c5ccdc3


# instance fields
.field public addedStickerFileIds:[I

.field public height:I

.field public media:Lorg/drinkless/tdlib/TdApi$InputFile;

.field public thumbnail:Lorg/drinkless/tdlib/TdApi$InputThumbnail;

.field public type:Lorg/drinkless/tdlib/TdApi$InputPaidMediaType;

.field public width:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 50122
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 50123
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$InputPaidMediaType;Lorg/drinkless/tdlib/TdApi$InputFile;Lorg/drinkless/tdlib/TdApi$InputThumbnail;[III)V
    .locals 0
    .param p1, "inputPaidMediaType"    # Lorg/drinkless/tdlib/TdApi$InputPaidMediaType;
    .param p2, "inputFile"    # Lorg/drinkless/tdlib/TdApi$InputFile;
    .param p3, "inputThumbnail"    # Lorg/drinkless/tdlib/TdApi$InputThumbnail;
    .param p4, "iArr"    # [I
    .param p5, "i9"    # I
    .param p6, "i10"    # I

    .line 50108
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 50109
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InputPaidMedia;->type:Lorg/drinkless/tdlib/TdApi$InputPaidMediaType;

    .line 50110
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$InputPaidMedia;->media:Lorg/drinkless/tdlib/TdApi$InputFile;

    .line 50111
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$InputPaidMedia;->thumbnail:Lorg/drinkless/tdlib/TdApi$InputThumbnail;

    .line 50112
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$InputPaidMedia;->addedStickerFileIds:[I

    .line 50113
    iput p5, p0, Lorg/drinkless/tdlib/TdApi$InputPaidMedia;->width:I

    .line 50114
    iput p6, p0, Lorg/drinkless/tdlib/TdApi$InputPaidMedia;->height:I

    .line 50115
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 50119
    const v0, 0x1c5ccdc3

    return v0
.end method
