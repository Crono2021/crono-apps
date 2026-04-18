.class public Lorg/drinkless/tdlib/TdApi$Backgrounds;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Backgrounds"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x2b327b80


# instance fields
.field public backgrounds:[Lorg/drinkless/tdlib/TdApi$Background;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 9096
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 9097
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$Background;)V
    .locals 0
    .param p1, "backgroundArr"    # [Lorg/drinkless/tdlib/TdApi$Background;

    .line 9087
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 9088
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$Backgrounds;->backgrounds:[Lorg/drinkless/tdlib/TdApi$Background;

    .line 9089
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 9093
    const v0, 0x2b327b80

    return v0
.end method
