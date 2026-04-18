.class public Lorg/drinkless/tdlib/TdApi$TextEntity;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "TextEntity"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x74546658


# instance fields
.field public length:I

.field public offset:I

.field public type:Lorg/drinkless/tdlib/TdApi$TextEntityType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 40988
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 40989
    return-void
.end method

.method public constructor <init>(IILorg/drinkless/tdlib/TdApi$TextEntityType;)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "i10"    # I
    .param p3, "textEntityType"    # Lorg/drinkless/tdlib/TdApi$TextEntityType;

    .line 40977
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 40978
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$TextEntity;->offset:I

    .line 40979
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$TextEntity;->length:I

    .line 40980
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$TextEntity;->type:Lorg/drinkless/tdlib/TdApi$TextEntityType;

    .line 40981
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 40985
    const v0, -0x74546658    # -6.6098E-32f

    return v0
.end method
