.class public Lorg/drinkless/tdlib/TdApi$MessageReadDateRead;
.super Lorg/drinkless/tdlib/TdApi$MessageReadDate;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageReadDateRead"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x758d2e30


# instance fields
.field public readDate:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 16656
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageReadDate;-><init>()V

    .line 16657
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "i9"    # I

    .line 16647
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageReadDate;-><init>()V

    .line 16648
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$MessageReadDateRead;->readDate:I

    .line 16649
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 16653
    const v0, 0x758d2e30

    return v0
.end method
