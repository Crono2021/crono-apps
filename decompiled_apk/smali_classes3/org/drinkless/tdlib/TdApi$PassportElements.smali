.class public Lorg/drinkless/tdlib/TdApi$PassportElements;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PassportElements"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x4b608854


# instance fields
.field public elements:[Lorg/drinkless/tdlib/TdApi$PassportElement;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 17664
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 17665
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$PassportElement;)V
    .locals 0
    .param p1, "passportElementArr"    # [Lorg/drinkless/tdlib/TdApi$PassportElement;

    .line 17655
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 17656
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PassportElements;->elements:[Lorg/drinkless/tdlib/TdApi$PassportElement;

    .line 17657
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 17661
    const v0, 0x4b608854    # 1.4714964E7f

    return v0
.end method
