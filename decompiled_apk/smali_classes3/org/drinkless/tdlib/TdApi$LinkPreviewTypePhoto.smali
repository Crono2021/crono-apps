.class public Lorg/drinkless/tdlib/TdApi$LinkPreviewTypePhoto;
.super Lorg/drinkless/tdlib/TdApi$LinkPreviewType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "LinkPreviewTypePhoto"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x51305554


# instance fields
.field public photo:Lorg/drinkless/tdlib/TdApi$Photo;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 15954
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$LinkPreviewType;-><init>()V

    .line 15955
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$Photo;)V
    .locals 0
    .param p1, "photo"    # Lorg/drinkless/tdlib/TdApi$Photo;

    .line 15945
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$LinkPreviewType;-><init>()V

    .line 15946
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$LinkPreviewTypePhoto;->photo:Lorg/drinkless/tdlib/TdApi$Photo;

    .line 15947
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 15951
    const v0, -0x51305554

    return v0
.end method
