.class public Lorg/drinkless/tdlib/TdApi$Animations;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Animations"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x14845571


# instance fields
.field public animations:[Lorg/drinkless/tdlib/TdApi$Animation;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 8790
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 8791
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$Animation;)V
    .locals 0
    .param p1, "animationArr"    # [Lorg/drinkless/tdlib/TdApi$Animation;

    .line 8781
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 8782
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$Animations;->animations:[Lorg/drinkless/tdlib/TdApi$Animation;

    .line 8783
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 8787
    const v0, 0x14845571

    return v0
.end method
