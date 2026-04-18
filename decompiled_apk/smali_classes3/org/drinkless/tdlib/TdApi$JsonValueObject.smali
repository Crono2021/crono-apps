.class public Lorg/drinkless/tdlib/TdApi$JsonValueObject;
.super Lorg/drinkless/tdlib/TdApi$JsonValue;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "JsonValueObject"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x1f026a7a


# instance fields
.field public members:[Lorg/drinkless/tdlib/TdApi$JsonObjectMember;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 15648
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$JsonValue;-><init>()V

    .line 15649
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$JsonObjectMember;)V
    .locals 0
    .param p1, "jsonObjectMemberArr"    # [Lorg/drinkless/tdlib/TdApi$JsonObjectMember;

    .line 15639
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$JsonValue;-><init>()V

    .line 15640
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$JsonValueObject;->members:[Lorg/drinkless/tdlib/TdApi$JsonObjectMember;

    .line 15641
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 15645
    const v0, 0x1f026a7a

    return v0
.end method
