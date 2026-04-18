.class public Lorg/drinkless/tdlib/TdApi$PaidMediaPhoto;
.super Lorg/drinkless/tdlib/TdApi$PaidMedia;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PaidMediaPhoto"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x457daae6


# instance fields
.field public photo:Lorg/drinkless/tdlib/TdApi$Photo;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 17322
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PaidMedia;-><init>()V

    .line 17323
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$Photo;)V
    .locals 0
    .param p1, "photo"    # Lorg/drinkless/tdlib/TdApi$Photo;

    .line 17313
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PaidMedia;-><init>()V

    .line 17314
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PaidMediaPhoto;->photo:Lorg/drinkless/tdlib/TdApi$Photo;

    .line 17315
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 17319
    const v0, -0x457daae6

    return v0
.end method
