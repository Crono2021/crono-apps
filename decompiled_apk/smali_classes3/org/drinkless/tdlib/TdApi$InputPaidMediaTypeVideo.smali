.class public Lorg/drinkless/tdlib/TdApi$InputPaidMediaTypeVideo;
.super Lorg/drinkless/tdlib/TdApi$InputPaidMediaType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputPaidMediaTypeVideo"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x6aea5339


# instance fields
.field public cover:Lorg/drinkless/tdlib/TdApi$InputFile;

.field public duration:I

.field public startTimestamp:I

.field public supportsStreaming:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 43974
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputPaidMediaType;-><init>()V

    .line 43975
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$InputFile;IIZ)V
    .locals 0
    .param p1, "inputFile"    # Lorg/drinkless/tdlib/TdApi$InputFile;
    .param p2, "i9"    # I
    .param p3, "i10"    # I
    .param p4, "z8"    # Z

    .line 43962
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputPaidMediaType;-><init>()V

    .line 43963
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InputPaidMediaTypeVideo;->cover:Lorg/drinkless/tdlib/TdApi$InputFile;

    .line 43964
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$InputPaidMediaTypeVideo;->startTimestamp:I

    .line 43965
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$InputPaidMediaTypeVideo;->duration:I

    .line 43966
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$InputPaidMediaTypeVideo;->supportsStreaming:Z

    .line 43967
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 43971
    const v0, 0x6aea5339

    return v0
.end method
