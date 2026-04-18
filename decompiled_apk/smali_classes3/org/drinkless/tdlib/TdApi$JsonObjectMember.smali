.class public Lorg/drinkless/tdlib/TdApi$JsonObjectMember;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "JsonObjectMember"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x6b7c516a


# instance fields
.field public key:Ljava/lang/String;

.field public value:Lorg/drinkless/tdlib/TdApi$JsonValue;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 27884
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 27885
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$JsonValue;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "jsonValue"    # Lorg/drinkless/tdlib/TdApi$JsonValue;

    .line 27874
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 27875
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$JsonObjectMember;->key:Ljava/lang/String;

    .line 27876
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$JsonObjectMember;->value:Lorg/drinkless/tdlib/TdApi$JsonValue;

    .line 27877
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 27881
    const v0, -0x6b7c516a

    return v0
.end method
