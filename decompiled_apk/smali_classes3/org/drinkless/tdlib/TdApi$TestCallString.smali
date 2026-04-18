.class public Lorg/drinkless/tdlib/TdApi$TestCallString;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "TestCallString"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$TestString;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x6748b5d1


# instance fields
.field public f8022x:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 20944
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 20945
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 20935
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 20936
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$TestCallString;->f8022x:Ljava/lang/String;

    .line 20937
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 20941
    const v0, -0x6748b5d1

    return v0
.end method
