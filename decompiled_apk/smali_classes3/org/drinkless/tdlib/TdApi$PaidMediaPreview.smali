.class public Lorg/drinkless/tdlib/TdApi$PaidMediaPreview;
.super Lorg/drinkless/tdlib/TdApi$PaidMedia;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PaidMediaPreview"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x433e3b8c


# instance fields
.field public duration:I

.field public height:I

.field public minithumbnail:Lorg/drinkless/tdlib/TdApi$Minithumbnail;

.field public width:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 44526
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PaidMedia;-><init>()V

    .line 44527
    return-void
.end method

.method public constructor <init>(IIILorg/drinkless/tdlib/TdApi$Minithumbnail;)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "i10"    # I
    .param p3, "i11"    # I
    .param p4, "minithumbnail"    # Lorg/drinkless/tdlib/TdApi$Minithumbnail;

    .line 44514
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PaidMedia;-><init>()V

    .line 44515
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$PaidMediaPreview;->width:I

    .line 44516
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$PaidMediaPreview;->height:I

    .line 44517
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$PaidMediaPreview;->duration:I

    .line 44518
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$PaidMediaPreview;->minithumbnail:Lorg/drinkless/tdlib/TdApi$Minithumbnail;

    .line 44519
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 44523
    const v0, -0x433e3b8c

    return v0
.end method
