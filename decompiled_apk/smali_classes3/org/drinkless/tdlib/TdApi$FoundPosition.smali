.class public Lorg/drinkless/tdlib/TdApi$FoundPosition;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "FoundPosition"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x70752078


# instance fields
.field public position:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 11958
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 11959
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "i9"    # I

    .line 11949
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 11950
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$FoundPosition;->position:I

    .line 11951
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 11955
    const v0, -0x70752078

    return v0
.end method
