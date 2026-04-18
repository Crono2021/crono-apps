.class public Lorg/drinkless/tdlib/TdApi$LabeledPricePart;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "LabeledPricePart"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x20f2e726


# instance fields
.field public amount:J

.field public label:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 27944
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 27945
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;J)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "j5"    # J

    .line 27934
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 27935
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$LabeledPricePart;->label:Ljava/lang/String;

    .line 27936
    iput-wide p2, p0, Lorg/drinkless/tdlib/TdApi$LabeledPricePart;->amount:J

    .line 27937
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 27941
    const v0, 0x20f2e726

    return v0
.end method
